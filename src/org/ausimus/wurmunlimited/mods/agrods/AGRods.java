package org.ausimus.wurmunlimited.mods.agrods;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.gotti.wurmunlimited.modloader.classhooks.HookException;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;

/**
 * Created by Ausimus on 2/2/2017.
 */

public class AGRods {
    public AGRods() {
        if (Initiator.UseAdaOnly) {
            try {
                ClassPool e = HookManager.getInstance().getClassPool();
                CtClass ctAdaandGlimmerRods;
                ctAdaandGlimmerRods = e.get("com.wurmonline.server.questions.OreQuestion");
                ctAdaandGlimmerRods.getDeclaredMethod("sendQuestion").setBody("{\n" +
                        "        StringBuilder buf = new StringBuilder(this.getBmlHeader());\n" +
                        "        buf.append(\"harray{label{text=\\'Tile type\\'}dropdown{id=\\'data1\\';options=\\\"\");\n" +
                        "        com.wurmonline.mesh.Tiles.Tile[] tiles = com.wurmonline.mesh.Tiles.Tile.getTiles();\n" +
                        "\n" +
                        "        for(int x = 0; x < tiles.length; ++x) {\n" +
                        "            if(tiles[x] != null && com.wurmonline.mesh.Tiles.isOreCave(tiles[x].id) && tiles[x].id != Tile.TILE_CAVE_WALL_ORE_GLIMMERSTEEL.id) {\n" +
                        "                this.oretiles.put(Integer.valueOf(this.numtiles), Integer.valueOf(x));\n" +
                        "                ++this.numtiles;\n" +
                        "                buf.append(tiles[x].tiledesc);\n" +
                        "                buf.append(\",\");\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        buf.append(\"No change\");\n" +
                        "        buf.append(\"\\\"}}\");\n" +
                        "        buf.append(this.createAnswerButton2());\n" +
                        "        this.getResponder().getCommunicator().sendBml(300, 300, true, true, buf.toString(), 200, 200, 200, this.title);\n" +
                        "    }");
            } catch (NotFoundException | CannotCompileException oops) {
                throw new HookException(oops);
            }
            if (Initiator.UseGlimmerOnly) {
                try {
                    ClassPool e = HookManager.getInstance().getClassPool();
                    CtClass ctAdaandGlimmerRods;
                    ctAdaandGlimmerRods = e.get("com.wurmonline.server.questions.OreQuestion");
                    ctAdaandGlimmerRods.getDeclaredMethod("sendQuestion").setBody("{\n" +
                            "        StringBuilder buf = new StringBuilder(this.getBmlHeader());\n" +
                            "        buf.append(\"harray{label{text=\\'Tile type\\'}dropdown{id=\\'data1\\';options=\\\"\");\n" +
                            "        com.wurmonline.mesh.Tiles.Tile[] tiles = com.wurmonline.mesh.Tiles.Tile.getTiles();\n" +
                            "\n" +
                            "        for(int x = 0; x < tiles.length; ++x) {\n" +
                            "            if(tiles[x] != null && com.wurmonline.mesh.Tiles.isOreCave(tiles[x].id) && != Tile.TILE_CAVE_WALL_ORE_ADAMANTINE.id) {\n" +
                            "                this.oretiles.put(Integer.valueOf(this.numtiles), Integer.valueOf(x));\n" +
                            "                ++this.numtiles;\n" +
                            "                buf.append(tiles[x].tiledesc);\n" +
                            "                buf.append(\",\");\n" +
                            "            }\n" +
                            "        }\n" +
                            "\n" +
                            "        buf.append(\"No change\");\n" +
                            "        buf.append(\"\\\"}}\");\n" +
                            "        buf.append(this.createAnswerButton2());\n" +
                            "        this.getResponder().getCommunicator().sendBml(300, 300, true, true, buf.toString(), 200, 200, 200, this.title);\n" +
                            "    }");
                } catch (NotFoundException | CannotCompileException oops) {
                    throw new HookException(oops);
                }
            }
        }
        if (Initiator.UseBoth) {
            try {
                ClassPool e = HookManager.getInstance().getClassPool();
                CtClass ctAdaandGlimmerRods;
                ctAdaandGlimmerRods = e.get("com.wurmonline.server.questions.OreQuestion");
                ctAdaandGlimmerRods.getDeclaredMethod("sendQuestion").setBody("{\n" +
                        "        StringBuilder buf = new StringBuilder(this.getBmlHeader());\n" +
                        "        buf.append(\"harray{label{text=\\'Tile type\\'}dropdown{id=\\'data1\\';options=\\\"\");\n" +
                        "        com.wurmonline.mesh.Tiles.Tile[] tiles = com.wurmonline.mesh.Tiles.Tile.getTiles();\n" +
                        "\n" +
                        "        for(int x = 0; x < tiles.length; ++x) {\n" +
                        "            if(tiles[x] != null && com.wurmonline.mesh.Tiles.isOreCave(tiles[x].id)) {\n" +
                        "                this.oretiles.put(Integer.valueOf(this.numtiles), Integer.valueOf(x));\n" +
                        "                ++this.numtiles;\n" +
                        "                buf.append(tiles[x].tiledesc);\n" +
                        "                buf.append(\",\");\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        buf.append(\"No change\");\n" +
                        "        buf.append(\"\\\"}}\");\n" +
                        "        buf.append(this.createAnswerButton2());\n" +
                        "        this.getResponder().getCommunicator().sendBml(300, 300, true, true, buf.toString(), 200, 200, 200, this.title);\n" +
                        "    }");
            } catch (NotFoundException | CannotCompileException oops) {
                throw new HookException(oops);
            }
        }
    }
}