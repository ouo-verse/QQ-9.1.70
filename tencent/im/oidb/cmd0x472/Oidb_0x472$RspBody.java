package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x472$RspBody extends MessageMicro<Oidb_0x472$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "rspChannelArticle"}, new Object[]{0L, null}, Oidb_0x472$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public Oidb_0x472$RspChannelArticle rspChannelArticle = new Oidb_0x472$RspChannelArticle();
}
