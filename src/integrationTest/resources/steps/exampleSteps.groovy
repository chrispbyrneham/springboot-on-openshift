this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

class CustomWorld {
    String customMethod() {
        "foo"
    }
}

World {
    new CustomWorld()
}

Before() {
    assert "foo" == customMethod()
}

Before("@notused") {
    throw new RuntimeException("Never happens")
}

Before("@notused,@important", "@alsonotused") {
    throw new RuntimeException("Never happens")
}

Given(~/^we have connection details$/) { ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}

When(~/^navigate to the greeting page$/) { ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}

Then(~/^the greeting is displayed$/) { ->
    // Write code here that turns the phrase above into concrete actions
    assert false
}
