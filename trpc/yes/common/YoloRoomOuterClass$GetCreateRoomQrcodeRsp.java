package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$GetCreateRoomQrcodeRsp extends MessageMicro<YoloRoomOuterClass$GetCreateRoomQrcodeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"create_url", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{"", 0}, YoloRoomOuterClass$GetCreateRoomQrcodeRsp.class);
    public final PBStringField create_url = PBField.initString("");
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
}
