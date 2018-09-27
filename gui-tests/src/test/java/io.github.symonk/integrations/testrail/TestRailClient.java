package io.github.symonk.integrations.testrail;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Run;
import io.github.symonk.configurations.properties.FrameworkProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TestRailClient {

  private final TestRail testRail;
  private final int projectId, suiteId;
  private final String runName;

  public TestRailClient(final FrameworkProperties properties) {
    testRail =
        TestRail.builder(
                properties.testrailEndpoint(),
                properties.testRailUsername(),
                properties.testRailPassword())
            .build();
    this.projectId = properties.testRailProjectId();
    this.suiteId = properties.testRailSuiteId();
    this.runName = properties.testRailRunName();
  }

  public TestRailClient instantiateRunWithTests(final List<Integer> listOfTestCases) {
    testRail
        .runs()
        .add(
            projectId,
            new Run()
                .setSuiteId(suiteId)
                .setName(runName)
                .setIncludeAll(false)
                .setCaseIds(listOfTestCases))
        .execute();
    return this;
  }

  public TestRailClient createRun() {
    testRail.runs().add(projectId, new Run().setSuiteId(suiteId).setName(runName).setIncludeAll(false));
    return this;
  }

  public TestRailClient instantiateRunWithAllTests() {
    testRail.runs().add(projectId, new Run().setSuiteId(suiteId).setName(runName)).execute();
    return this;
  }
}
