package com.yzzer.newfeatures;

public sealed class SealedTest permits Animal, Other, Person {
}
non-sealed class Person extends SealedTest {

}

final class Animal extends SealedTest {

}

sealed class Other extends SealedTest permits Hello {

}

final class Hello extends Other {

}