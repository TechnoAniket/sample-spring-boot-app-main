package com.sample.service;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.togglz.junit.TogglzRule;

import com.sample.features.FeatureToggle;


@Category(DisplayServiceTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DisplayServiceTest {

    private DisplayService displayService;
    
    @Rule
    public TogglzRule togglzRule = TogglzRule.allEnabled(FeatureToggle.class);

    @Before
    public void setUp() throws Exception {
        displayService = new DisplayService();
    }

    @Test
    public void serViceShouldReturnString() {
        togglzRule.enable(FeatureToggle.MOCKSERVICE);
        //Given
        String name = "Sam";

        //When
        String result = displayService.sayHello(name);

        //Then
        Assert.assertEquals(result, "Hello Sam");
    }

    @Ignore("This is ignored")
    @Test
    public void ignoredSerViceShouldReturnString() {

        togglzRule.disable(FeatureToggle.MOCKSERVICE);

        //Given
        String name = "Sam";

        //When
        String result = displayService.sayHello(name);

        //Then
        Assert.assertEquals(result, "Hello Sam");
    }

    @After
    public void printAfterMessgae() {
        System.out.println("This is After message");
    }

    @BeforeClass
    public static void printBeforeClassMessgae() {
        System.out.println("This is Before Class message");
    }

    @AfterClass
    public static void printAfterClassMessgae() {
        System.out.println("This is After Class message");
    }
}
