package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class apollo_game_status$STGameStateMsgList extends MessageMicro<apollo_game_status$STGameStateMsgList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_list"}, new Object[]{null}, apollo_game_status$STGameStateMsgList.class);
    public final PBRepeatMessageField<apollo_game_status$STCMGameMessage> rpt_msg_list = PBField.initRepeatMessage(apollo_game_status$STCMGameMessage.class);
}
