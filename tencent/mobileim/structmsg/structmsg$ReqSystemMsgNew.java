package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$ReqSystemMsgNew extends MessageMicro<structmsg$ReqSystemMsgNew> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBEnumField checktype = PBField.initEnum(1);
    public structmsg$FlagInfo flag = new structmsg$FlagInfo();
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBBoolField is_get_frd_ribbon = PBField.initBool(true);
    public final PBBoolField is_get_grp_ribbon = PBField.initBool(true);
    public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_uid = PBField.initUInt32(0);

    static {
        String[] strArr = {"msg_num", "latest_friend_seq", "latest_group_seq", "version", "checktype", "flag", IjkMediaMeta.IJKM_KEY_LANGUAGE, "is_get_frd_ribbon", "is_get_grp_ribbon", "friend_msg_type_flag", "uint32_req_msg_type", "uint32_need_uid"};
        Boolean bool = Boolean.TRUE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88, 128}, strArr, new Object[]{0, 0L, 0L, 0, 1, null, 0, bool, bool, 0L, 0, 0}, structmsg$ReqSystemMsgNew.class);
    }
}
