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
    @Test
    public void simpleMatchingAssertion() {
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
    public void bibleWordsCountExpectedResultCorrectnessAssertion() {

    }
}