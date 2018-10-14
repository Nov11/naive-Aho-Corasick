package io.nov11;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.junit.*;
import org.junit.rules.TestRule;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@BenchmarkOptions(callgc = true, benchmarkRounds = 40, warmupRounds = 20)
public class BenchMarkGCBeforeEveryRoundTest {
    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private static String content;

    private static List<String> words;

    private static AhoCorasick ahoCorasick;
    private static Set<String> resultOfMine;

    private static Trie trieFromRobertBor;
    private static Collection<Emit> resultOfRobertBors;

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

    @AfterClass
    public static void finish() {
        Set<String> set = resultOfRobertBors.stream().map(Emit::getKeyword).collect(Collectors.toSet());
        Assert.assertEquals(words.size(), set.size());
        Assert.assertEquals(resultOfMine.size(), set.size());
    }

    @Test
    public void benchmarkTestRobertBors() {
        Collection<Emit> ret = trieFromRobertBor.parseText(content);
        resultOfRobertBors = ret;
        Assert.assertNotNull(ret);
    }

    @Test
    public void benchmarkTest() {
        Set<String> ret = ahoCorasick.match(content);
        resultOfMine = ret;
        Assert.assertEquals(words.size(), ret.size());
    }
}
