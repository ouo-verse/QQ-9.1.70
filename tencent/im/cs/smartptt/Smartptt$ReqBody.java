package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Smartptt$ReqBody extends MessageMicro<Smartptt$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_sub_cmd", "msg_ptt_up_req", "msg_tts_req"}, new Object[]{0, null, null}, Smartptt$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public Smartptt$PttUpReq msg_ptt_up_req = new Smartptt$PttUpReq();
    public Smartptt$TTSReq msg_tts_req = new MessageMicro<Smartptt$TTSReq>() { // from class: tencent.im.cs.smartptt.Smartptt$TTSReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Smartptt$TTSReq.class);
    };
}
