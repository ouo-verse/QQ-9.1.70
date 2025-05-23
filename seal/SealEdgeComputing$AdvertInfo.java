package seal;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SealEdgeComputing$AdvertInfo extends MessageMicro<SealEdgeComputing$AdvertInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt64Field advert_id = PBField.initInt64(0);
    public final PBBoolField use_rcmd_advert_room_switch = PBField.initBool(false);
    public final PBBoolField can_show_advert_room = PBField.initBool(false);
    public final PBBoolField allow_ad_repull = PBField.initBool(false);
    public final PBBytesField ad_repull_feature = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField replaced_ad_feedid = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"advert_id", "use_rcmd_advert_room_switch", "can_show_advert_room", "allow_ad_repull", "ad_repull_feature", "replaced_ad_feedid"}, new Object[]{0L, bool, bool, bool, ByteStringMicro.EMPTY, ""}, SealEdgeComputing$AdvertInfo.class);
    }
}
