package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$RspShareTransCheck extends MessageMicro<aio_media$RspShareTransCheck> {
    static final MessageMicro.FieldMap __fieldMap__;
    public aio_media$ResultInfo msg_result = new aio_media$ResultInfo();
    public final PBEnumField enum_aio_state = PBField.initEnum(1);
    public final PBEnumField enum_media_type = PBField.initEnum(1);
    public final PBBoolField bool_show_icon = PBField.initBool(false);
    public final PBStringField str_song_id = PBField.initString("");
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0);
    public final PBBoolField bool_song_existed = PBField.initBool(false);
    public final PBBoolField bool_allow_member_start = PBField.initBool(true);
    public final PBBoolField bool_allow_member_add = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56, 64, 72, 80}, new String[]{"msg_result", "enum_aio_state", "enum_media_type", "bool_show_icon", "str_song_id", "uint32_duration", "uint64_create_uin", "bool_song_existed", "bool_allow_member_start", "bool_allow_member_add"}, new Object[]{null, 1, 1, bool, "", 0, 0L, bool, Boolean.TRUE, bool}, aio_media$RspShareTransCheck.class);
    }
}
