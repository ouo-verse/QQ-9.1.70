package tencent.im.oidb.cmd0xe26;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe26$RspBody extends MessageMicro<oidb_0xe26$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "refresh_second", "template_list"}, new Object[]{0, ByteStringMicro.EMPTY, 0, null}, oidb_0xe26$RspBody.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field refresh_second = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xe26$EntranceTemplate> template_list = PBField.initRepeatMessage(oidb_0xe26$EntranceTemplate.class);
}
