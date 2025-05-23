package tencent.im.oidb.cmd0xfe3;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfe3$RspBody extends MessageMicro<oidb_cmd0xfe3$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{INetChannelCallback.KEY_TINY_ID}, new Object[]{""}, oidb_cmd0xfe3$RspBody.class);
    public final PBStringField tiny_id = PBField.initString("");
}
