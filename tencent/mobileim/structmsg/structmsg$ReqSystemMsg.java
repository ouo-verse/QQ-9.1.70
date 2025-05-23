package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$ReqSystemMsg extends MessageMicro<structmsg$ReqSystemMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"msg_num", "latest_friend_seq", "latest_group_seq", "version", IjkMediaMeta.IJKM_KEY_LANGUAGE}, new Object[]{0, 0L, 0L, 0, 0}, structmsg$ReqSystemMsg.class);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field language = PBField.initUInt32(0);
}
