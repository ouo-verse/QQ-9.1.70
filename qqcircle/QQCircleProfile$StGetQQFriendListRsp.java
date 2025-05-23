package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StGetQQFriendListRsp extends MessageMicro<QQCircleProfile$StGetQQFriendListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QZoneCheckSendGiftServlet.PARAM_FRINED_LIST, "uint64_friend_uins"}, new Object[]{0, 0L}, QQCircleProfile$StGetQQFriendListRsp.class);
    public final PBRepeatField<Integer> friendList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> uint64_friend_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
