package digital.naomie;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.io.IOException;

// Written by Xpple at https://raw.githubusercontent.com/xpple/BetterConfig/master/src/testmod/java/dev/xpple/betterconfig/BlockAdapter.java
class BlockAdapter extends TypeAdapter<Block> {
    @Override
    public void write(JsonWriter writer, Block block) throws IOException {
        writer.value(Registries.BLOCK.getId(block).toString());
    }

    @Override
    public Block read(JsonReader reader) throws IOException {
        return Registries.BLOCK.get(new Identifier(reader.nextString()));
    }
}