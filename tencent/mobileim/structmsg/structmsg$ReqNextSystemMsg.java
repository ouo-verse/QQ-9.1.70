package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$ReqNextSystemMsg extends MessageMicro<structmsg$ReqNextSystemMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 128}, new String[]{"msg_num", "following_friend_seq", "following_group_seq", "checktype", "flag", IjkMediaMeta.IJKM_KEY_LANGUAGE, "version", "friend_msg_type_flag", "uint32_req_msg_type", "uint32_need_uid"}, new Object[]{0, 0L, 0L, 1, null, 0, 0, 0L, 0, 0}, structmsg$ReqNextSystemMsg.class);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt64Field following_friend_seq = PBField.initUInt64(0);
    public final PBUInt64Field following_group_seq = PBField.initUInt64(0);
    public final PBEnumField checktype = PBField.initEnum(1);
    public structmsg$FlagInfo flag = new structmsg$FlagInfo();
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_uid = PBField.initUInt32(0);
}
