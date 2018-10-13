package io.nov11;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AhoCorasickTest {
    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private static String content;

    private static List<String> words;

    private static AhoCorasick ahoCorasick;

    private static Trie trieFromRobertBor;

    @BeforeClass
    public static void init() throws Exception {
        String fileName = "src/test/resources/kjvdat.txt";
        String wordList = "src/test/resources/words";

        byte[] contentBytes = Files.readAllBytes(Paths.get(fileName));
        content = new String(contentBytes, StandardCharsets.UTF_8).toLowerCase();
        words = Files.readAllLines(Paths.get(wordList));
        ahoCorasick = new AhoCorasick(words);


        Trie.TrieBuilder builder = Trie.builder();
        for (String s : words) {
            builder.addKeyword(s);
        }
        trieFromRobertBor = builder.build();
    }

    @Test
    public void match() {
        List<String> needles = new ArrayList<>();
        needles.add("he");
        needles.add("she");
        needles.add("his");
        needles.add("hers");
        AhoCorasick ahoCorasick = new AhoCorasick(needles);

        Set<String> ret = ahoCorasick.match("ushers");

        Assert.assertTrue(ret.contains("she"));
        Assert.assertTrue(ret.contains("he"));
        Assert.assertTrue(ret.contains("hers"));

    }

    @Test
    public void benchmarkTest() {
        Set<String> ret = ahoCorasick.match(content);
        Assert.assertEquals(words.size(), ret.size());
    }

    @Test
    public void robert_bor_aho_corasick() {
        Collection<Emit> ret = trieFromRobertBor.parseText(content);
        Set<String> result = ret.stream().map(Emit::getKeyword).collect(Collectors.toSet());
        Assert.assertEquals(words.size(), result.size());
    }
}