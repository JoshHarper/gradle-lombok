package net.franz_becker.gradle.lombok

import net.franz_becker.gradle.lombok.util.HashUtil
import spock.lang.Specification

/**
 * Simple test for {@link HashUtil}.
 */
class HashUtilSpec extends Specification {

    def "Calculates dummy.txt hash correctly"() {
        given:
        def file = new File(getClass().getClassLoader().getResource("dummy.txt").path)
        assert file.exists()

        when:
        def hash = HashUtil.calculateSha256(file)

        then:
        hash == "c626d18d337f2937a83bf82581e8b22796f345736f94a2ed60b0294b4705c203"
    }

    def "Throws RuntimeException if file is not found"() {
        given:
        def file = new File("unknown")
        assert !file.exists()

        when:
        HashUtil.calculateSha256(file)

        then:
        thrown(RuntimeException)
    }

}
