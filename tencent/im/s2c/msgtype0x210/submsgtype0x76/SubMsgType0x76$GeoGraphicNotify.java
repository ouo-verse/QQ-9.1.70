package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x76$GeoGraphicNotify extends MessageMicro<SubMsgType0x76$GeoGraphicNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_local_city", "rpt_msg_one_friend"}, new Object[]{ByteStringMicro.EMPTY, null}, SubMsgType0x76$GeoGraphicNotify.class);
    public final PBBytesField bytes_local_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<SubMsgType0x76$OneGeoGraphicFriend> rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76$OneGeoGraphicFriend.class);
}
