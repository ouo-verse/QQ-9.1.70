package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$RespGetList extends MessageMicro<nearfield_discuss$RespGetList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 64}, new String[]{"msg_head", "rpt_msg_user_list", "uint32_session_id", "int32_update_interval", "bytes_cookie", "uint32_button_switch", "uint32_has_created", "uint64_creator"}, new Object[]{null, null, 0, 0, ByteStringMicro.EMPTY, 0, 0, 0L}, nearfield_discuss$RespGetList.class);
    public nearfield_discuss$BusiRespHead msg_head = new nearfield_discuss$BusiRespHead();
    public final PBRepeatMessageField<nearfield_discuss$UserProfile> rpt_msg_user_list = PBField.initRepeatMessage(nearfield_discuss$UserProfile.class);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    public final PBInt32Field int32_update_interval = PBField.initInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_button_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_created = PBField.initUInt32(0);
    public final PBUInt64Field uint64_creator = PBField.initUInt64(0);
}
