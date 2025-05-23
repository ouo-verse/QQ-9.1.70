package tvideo;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum EpisodeListStyle implements WireEnum {
    EpisodeListStyleSquare(0),
    EpisodeListStyleLongStrip(1);

    public static final ProtoAdapter<EpisodeListStyle> ADAPTER = new EnumAdapter<EpisodeListStyle>() { // from class: tvideo.EpisodeListStyle.a
        {
            Syntax syntax = Syntax.PROTO_3;
            EpisodeListStyle episodeListStyle = EpisodeListStyle.EpisodeListStyleSquare;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EpisodeListStyle fromValue(int i3) {
            return EpisodeListStyle.fromValue(i3);
        }
    };
    private final int value;

    EpisodeListStyle(int i3) {
        this.value = i3;
    }

    public static EpisodeListStyle fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return EpisodeListStyleLongStrip;
        }
        return EpisodeListStyleSquare;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
