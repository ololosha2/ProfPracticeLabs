package practice_lab2.common;

import java.io.IOException;

/**
 * Loads data units group information.
 */
public interface DataGroupLoader {
    int load(DataGroup group) throws IOException;
}
