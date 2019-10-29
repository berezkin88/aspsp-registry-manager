package de.adorsys.registry.manager.service;

public interface AspspCsvService {

    byte[] exportCsv();

    void importCsv(byte[] file);

    /**
     * Merges the input data into existing database records.
     * <p>
     * Converts the input bytes into a list of {@link AspspPO}, then travers through
     * the lists for separating objects that could be safely updated, added and those,
     * that should have an additional processing for merging.
     * <p>
     * If ASPSP is not present in the database, is present with existing id or
     * acquired with no id (id is NULL), however, is already exists within repository, those are
     * considered as safe to simply add or update by calling saveAll(). All entries
     * that exist in repository but were passed with different id (entities with
     * same BIC and Bank Code are already present in the repository) will be deleted
     * first and then added with a new input identifiers.
     *
     * @param file as an array of bytes
     */
    void merge(byte[] file);
}
