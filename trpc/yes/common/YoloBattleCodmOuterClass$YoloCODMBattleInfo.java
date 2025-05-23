package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleCodmOuterClass$YoloCODMBattleInfo extends MessageMicro<YoloBattleCodmOuterClass$YoloCODMBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 90, 800, 810, 816, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO}, new String[]{"status", "codm_config", "codm_schema", "room_addr", "last_event_type", "last_event", "last_event_seq", "last_event_md5"}, new Object[]{1, null, null, null, 0, null, 0, ""}, YoloBattleCodmOuterClass$YoloCODMBattleInfo.class);
    public final PBEnumField status = PBField.initEnum(1);
    public YoloBattleCodmOuterClass$YoloCODMBattleConfig codm_config = new YoloBattleCodmOuterClass$YoloCODMBattleConfig();
    public YoloBattleCodmOuterClass$YoloCODMSchema codm_schema = new YoloBattleCodmOuterClass$YoloCODMSchema();
    public YoloBattleCodmOuterClass$YoloCODMRoomAddr room_addr = new MessageMicro<YoloBattleCodmOuterClass$YoloCODMRoomAddr>() { // from class: trpc.yes.common.YoloBattleCodmOuterClass$YoloCODMRoomAddr
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"group_room_id", "group_room_guid", "room_svr_addr"}, new Object[]{"", "", ""}, YoloBattleCodmOuterClass$YoloCODMRoomAddr.class);
        public final PBStringField group_room_id = PBField.initString("");
        public final PBStringField group_room_guid = PBField.initString("");
        public final PBStringField room_svr_addr = PBField.initString("");
    };
    public final PBEnumField last_event_type = PBField.initEnum(0);
    public YoloBattleCodmOuterClass$YoloOneCODMBattleEvent last_event = new YoloBattleCodmOuterClass$YoloOneCODMBattleEvent();
    public final PBInt32Field last_event_seq = PBField.initInt32(0);
    public final PBStringField last_event_md5 = PBField.initString("");
}
