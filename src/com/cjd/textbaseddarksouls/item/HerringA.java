package com.cjd.textbaseddarksouls.item;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Item;

public class HerringA implements Item {
  private final String name = "an A from Mr. Herring";

  public String getName() { return name; }
}
