package com.julianduru.util.validation;

import com.julianduru.util.ValidatorUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * created by julian on 19/04/2022
 */
public class URLCollectionTest {


    @Test
    public void testingURLValidation() throws Exception {
        var testItem1 = new TestItem();
        testItem1.setUrls(
            Set.of(
                "www.sample.com",
                "http://www.sample.com",
                "http://www.sample.com/path/to/file",
                "http://www.sample.com:89/path/to/file"
            )
        );

        var testItem2 = new TestItem();
        testItem2.setUrls(
            Set.of(
                "http://www.sample.com",
                "http://www.sample.com/path/to/file",
                "http://www.sample.com:89/path/to/file"
            )
        );

        assertThat(ValidatorUtil.isValid(testItem1)).isFalse();
        assertThat(ValidatorUtil.isValid(testItem2)).isTrue();
    }



    @Data
    class TestItem {


        @URLCollection
        public Set<String> urls;


    }

}
