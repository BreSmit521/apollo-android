// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment.fragment;

import com.apollographql.apollo.api.FragmentResponseFieldMapper;
import com.apollographql.apollo.api.GraphqlFragment;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Optional;
import com.apollographql.apollo.api.internal.Utils;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HeroDetails implements GraphqlFragment {
  static final ResponseField[] $responseFields = {
    ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forFragment("__typename", "__typename", Arrays.asList("Human"))
  };

  public static final String FRAGMENT_DEFINITION = "fragment HeroDetails on Character {\n"
      + "  __typename\n"
      + "  name\n"
      + "  ... HumanDetails\n"
      + "}";

  public static final List<String> POSSIBLE_TYPES = Collections.unmodifiableList(Arrays.asList( "Human", "Droid"));

  final @NotNull String __typename;

  final @NotNull String name;

  private final @NotNull Fragments fragments;

  private transient volatile String $toString;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  public HeroDetails(@NotNull String __typename, @NotNull String name,
      @NotNull Fragments fragments) {
    this.__typename = Utils.checkNotNull(__typename, "__typename == null");
    this.name = Utils.checkNotNull(name, "name == null");
    this.fragments = Utils.checkNotNull(fragments, "fragments == null");
  }

  public @NotNull String __typename() {
    return this.__typename;
  }

  /**
   * The name of the character
   */
  public @NotNull String name() {
    return this.name;
  }

  public @NotNull Fragments fragments() {
    return this.fragments;
  }

  @SuppressWarnings("unchecked")
  public ResponseFieldMarshaller marshaller() {
    return new ResponseFieldMarshaller() {
      @Override
      public void marshal(ResponseWriter writer) {
        writer.writeString($responseFields[0], __typename);
        writer.writeString($responseFields[1], name);
        fragments.marshaller().marshal(writer);
      }
    };
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "HeroDetails{"
        + "__typename=" + __typename + ", "
        + "name=" + name + ", "
        + "fragments=" + fragments
        + "}";
    }
    return $toString;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HeroDetails) {
      HeroDetails that = (HeroDetails) o;
      return this.__typename.equals(that.__typename)
       && this.name.equals(that.name)
       && this.fragments.equals(that.fragments);
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int h = 1;
      h *= 1000003;
      h ^= __typename.hashCode();
      h *= 1000003;
      h ^= name.hashCode();
      h *= 1000003;
      h ^= fragments.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  public static class Fragments {
    final Optional<HumanDetails> humanDetails;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Fragments(@Nullable HumanDetails humanDetails) {
      this.humanDetails = Optional.fromNullable(humanDetails);
    }

    public Optional<HumanDetails> humanDetails() {
      return this.humanDetails;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          final HumanDetails $humanDetails = humanDetails.isPresent() ? humanDetails.get() : null;
          if ($humanDetails != null) {
            $humanDetails.marshaller().marshal(writer);
          }
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Fragments{"
          + "humanDetails=" + humanDetails
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Fragments) {
        Fragments that = (Fragments) o;
        return this.humanDetails.equals(that.humanDetails);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= humanDetails.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
      final HumanDetails.Mapper humanDetailsFieldMapper = new HumanDetails.Mapper();

      @Override
      public @NotNull Fragments map(ResponseReader reader, @NotNull String conditionalType) {
        HumanDetails humanDetails = null;
        if (HumanDetails.POSSIBLE_TYPES.contains(conditionalType)) {
          humanDetails = humanDetailsFieldMapper.map(reader);
        }
        return new Fragments(humanDetails);
      }
    }
  }

  public static final class Mapper implements ResponseFieldMapper<HeroDetails> {
    final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

    @Override
    public HeroDetails map(ResponseReader reader) {
      final String __typename = reader.readString($responseFields[0]);
      final String name = reader.readString($responseFields[1]);
      final Fragments fragments = reader.readConditional($responseFields[2], new ResponseReader.ConditionalTypeReader<Fragments>() {
        @Override
        public Fragments read(String conditionalType, ResponseReader reader) {
          return fragmentsFieldMapper.map(reader, conditionalType);
        }
      });
      return new HeroDetails(__typename, name, fragments);
    }
  }
}
