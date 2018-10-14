package io.nov11;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
}