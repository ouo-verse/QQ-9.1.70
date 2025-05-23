package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class aio_media$SongExtendedReqParam extends MessageMicro<aio_media$SongExtendedReqParam> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField str_song_id = PBField.initString("");
    public final PBBoolField bool_need_url = PBField.initBool(false);
    public final PBBoolField bool_need_lyric = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"str_song_id", "bool_need_url", "bool_need_lyric"}, new Object[]{"", bool, bool}, aio_media$SongExtendedReqParam.class);
    }
}
