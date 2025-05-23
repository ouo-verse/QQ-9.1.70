package tencent.im.oidb.cmd0x9c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c9$SetNearbyTagReq extends MessageMicro<cmd0x9c9$SetNearbyTagReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tag_id"}, new Object[]{""}, cmd0x9c9$SetNearbyTagReq.class);
    public final PBRepeatField<String> tag_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}
