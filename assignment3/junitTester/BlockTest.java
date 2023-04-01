package assignment3Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;

import assignment3.*;

import java.lang.reflect.Field;

public class BlockTest {

    static String BLOCK_CHILDREN_FIELD_NAME = "children"; //this should be set to the name of your block's "children" field
    static String BLOCK_XCOORD_FIELD_NAME = "xCoord";
    static String BLOCK_YCOORD_FIELD_NAME = "yCoord";
    static String BLOCK_SIZE_FIELD_NAME = "size";

    public Field privateChildrenField;
    public Field privateXCoordField;
    public Field privateYCoordField;
    public Field privateSizeField;


    {
        try {
            privateChildrenField = Block.class.getDeclaredField(BLOCK_CHILDREN_FIELD_NAME);
            privateXCoordField = Block.class.getDeclaredField(BLOCK_XCOORD_FIELD_NAME);
            privateYCoordField = Block.class.getDeclaredField(BLOCK_YCOORD_FIELD_NAME);
            privateSizeField = Block.class.getDeclaredField(BLOCK_SIZE_FIELD_NAME);
        }
        catch(NoSuchFieldException ignored){
            // I know, printing when I said not to. This is not a test, you just need this for the tests to work :/
            System.out.println("The global field names must match your Block's field names");
        }
    }

    @Test
    public void Block_randomConstructor_instantiates(){
        Block myBlock = new Block(0, 3);
    }


    @ParameterizedTest
    @Tag("BlockTest") @DisplayName("randomConstructor throws when negative level")
    @ValueSource(strings = {"-1", "-3", "-4", "-5555"})
    void Block_randomConstructor_throwsIllegalArgumentExceptionWhenNegativeLevel(Integer targetLevel) {
        assertThrows(IllegalArgumentException.class, ()->{
            Block myBlock = new Block(targetLevel, 3);
        });
    }

    @ParameterizedTest
    @Tag("BlockTest") @DisplayName("randomConstructor throws when non positive max depth")
    @ValueSource(strings = {"0", "-1", "-3", "-4", "-5555"})
    void Block_randomConstructor_throwsIllegalArgumentExceptionWhenNonPositiveMaxDepth(Integer targetMaxDepth) {
        assertThrows(IllegalArgumentException.class, ()->{
            Block myBlock = new Block(0, targetMaxDepth);
        });
    }

    @ParameterizedTest
    @Tag("BlockTest") @DisplayName("randomConstructor throws when level is greater than than max depth")
    @ValueSource(strings = {"2", "3", "4", "5", "6"})
    void Block_randomConstructor_throwsIllegalArgumentExceptionWhenLevelGreaterThanMaxDepth(Integer targetLevel) {
        assertThrows(IllegalArgumentException.class, ()->{
            Block myBlock = new Block(targetLevel, 1);
        });
    }


    @Test
    public void Block_randomConstructor_randomSmashingWorksAsExpected() throws IllegalAccessException {
        // This is more of an integration test and kind of goes against the tester's guidelines. I apologize,
        // but I still think it's better to have it and I didn't find a better way to test this.
        // If you find a better way to verify that the random Block constructor generates sub-block in the right way,
        // please implement it. - Julien
        Block myBlock = new Block(0, 2);
        //this test requires seeding the random generator with 2 as in: Random(2);
        //levels are the only verifiable/replicatable elements of the teacher's example on page 9
        privateChildrenField.setAccessible(true);
        Block[] childrens = (Block[]) privateChildrenField.get(myBlock);


            assertNotNull(childrens);

            assertEquals(0, myBlock.getLevel());
            assertEquals(4, childrens.length);

            // level 1 children
            for(int i = 0; i<4; i++){
                assertEquals(1, childrens[i].getLevel());
            }

            //childrens of the fourth children: level 2 children
            childrens = (Block[])privateChildrenField.get(childrens[3]);
            assertEquals(4, childrens.length);
            for(int i = 0; i<4; i++){
                assertEquals(2, childrens[i].getLevel());
            }
    }

    @Test
    public void Block_updateSizeAndPosition_WorksAsExpected() throws IllegalAccessException {
        // This is more of an integration test and kind of goes against the tester's guidelines. I apologize,
        // but I still think it's better to have it and I didn't find a better way to test this.
        // If you find a better way to verify that the random Block constructor generates sub-block in the right way,
        // please implement it. - Julien
        Block myBlock = new Block(0, 2);
        myBlock.updateSizeAndPosition(16, 0, 0);

        //this test requires seeding the random generator with 2 as in: Random(2);
        //levels are the only verifiable/replicatable elements of the teacher's example on page 10
        //assertEquals(new int[]{0, 0}, getBlockCoordinates(myBlock));

        privateChildrenField.setAccessible(true);
        Block[] childrens = (Block[]) privateChildrenField.get(myBlock);
        // todo set size and coords
        //todo check all size and pos are ok
    }


    private int[] getBlockCoordinates(Block block){
        int[] coordinates = new int[2];
        return coordinates;
    }

    //todo test for errors



    //seeder tests:
    //todo new block 0 2 returns expected block




}
