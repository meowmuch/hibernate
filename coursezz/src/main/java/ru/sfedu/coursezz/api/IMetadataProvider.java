package ru.sfedu.coursezz.api;

import java.util.List;

public interface IMetadataProvider {
    List getSchema();

    List getTables();

    List getDetails();

    List getSchemaName();
}
