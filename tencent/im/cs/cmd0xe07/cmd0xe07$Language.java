package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$Language extends MessageMicro<cmd0xe07$Language> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{IjkMediaMeta.IJKM_KEY_LANGUAGE, "languageDesc"}, new Object[]{"", ""}, cmd0xe07$Language.class);
    public final PBStringField language = PBField.initString("");
    public final PBStringField languageDesc = PBField.initString("");
}
