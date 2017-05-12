package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public interface Item {
  String getName();
  default boolean equals(Item other) {
    return getClass().getName().equals(other.getClass().getName());
  }
}
