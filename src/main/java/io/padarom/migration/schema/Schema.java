package io.padarom.migration.schema;

import java.util.function.Consumer;

public final class Schema {
    public static String instance = null;

    protected Schema() {}

    public static void table(String table, Consumer<Blueprint> lambda) {

    }

    public static void create(String table, Consumer<Blueprint> lambda) {
        Blueprint blueprint = Schema.createBlueprint(table);

        blueprint.create();
        lambda.accept(blueprint);

        Schema.build(blueprint);
    }

    public static void drop(String table) {

    }

    public static void dropIfExists(String table) {

    }

    public static void rename(String from, String to) {

    }

    private static void build(Blueprint blueprint) {
        blueprint.build(); // Connection übergeben
    }

    private static Blueprint createBlueprint(String table, Consumer<Blueprint> lambda) {
        return new Blueprint(table, lambda);
    }

    private static Blueprint createBlueprint(String table) {
        return new Blueprint(table, null);
    }
}