package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

public class RandomBsnTest {
    @Test
    public void ensureNoDuplicates() {
        Set<String> generatedBsns = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            String bsn = new RandomBsn().toTarget(null, null);
            assertFalse("Duplicated value at loop: " + i, generatedBsns.contains(bsn));
            generatedBsns.add(bsn);
        }
    }
}
