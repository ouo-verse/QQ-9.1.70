package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x990$RspBody extends MessageMicro<oidb_0x990$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_translate_rsp", "msg_batch_translate_rsp"}, new Object[]{null, null}, oidb_0x990$RspBody.class);
    public oidb_0x990$TranslateRsp msg_translate_rsp = new oidb_0x990$TranslateRsp();
    public oidb_0x990$BatchTranslateRsp msg_batch_translate_rsp = new oidb_0x990$BatchTranslateRsp();
}
