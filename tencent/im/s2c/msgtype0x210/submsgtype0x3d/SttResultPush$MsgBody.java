package tencent.im.s2c.msgtype0x210.submsgtype0x3d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class SttResultPush$MsgBody extends MessageMicro<SttResultPush$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_sub_cmd", "msg_ptt_resp", "msg_ptt_shard_resp"}, new Object[]{0, null, null}, SttResultPush$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public SttResultPush$TransPttResp msg_ptt_resp = new SttResultPush$TransPttResp();
    public SttResultPush$TransPttShardRsp msg_ptt_shard_resp = new SttResultPush$TransPttShardRsp();
}
