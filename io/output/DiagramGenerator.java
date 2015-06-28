package io.output;

import io.part.AbstractPuml;
import io.part.Puml;

import javax.annotation.Generated;

public abstract class DiagramGenerator {
	protected abstract void generate(Puml puml);
}
