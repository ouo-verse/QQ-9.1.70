package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloBattleOBStatusChangeAction extends MessageMicro<YoloRoomOuterClass$YoloBattleOBStatusChangeAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 82}, new String[]{"status", "ob_url", "pic_url", "ob_close_event"}, new Object[]{0, "", "", null}, YoloRoomOuterClass$YoloBattleOBStatusChangeAction.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField ob_url = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public YoloBattleObOuterClass$YoloBattleOBClosedEvent ob_close_event = new MessageMicro<YoloBattleObOuterClass$YoloBattleOBClosedEvent>() { // from class: trpc.yes.common.YoloBattleObOuterClass$YoloBattleOBClosedEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"status", "battle_base_info"}, new Object[]{0, null}, YoloBattleObOuterClass$YoloBattleOBClosedEvent.class);
        public final PBEnumField status = PBField.initEnum(0);
        public YoloBattleOuterClass$YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
    };
}
