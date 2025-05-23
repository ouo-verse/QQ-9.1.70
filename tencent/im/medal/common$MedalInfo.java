package tencent.im.medal;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$MedalInfo extends MessageMicro<common$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 32, 42, 48, 56, 66, 90, 248, 290, 320, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336, a.CTRL_INDEX, g.CTRL_INDEX, 360, 368, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, 386, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 402, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 434, 442, TroopInfo.PAY_PRIVILEGE_ALL, QFSNumberConstants.Int.NUM_456, m0.CTRL_INDEX, JsApiEnableDeviceOrientation.CTRL_INDEX, 480, 488, w.CTRL_INDEX}, new String[]{"uint32_id", "uint32_type", "uint32_seq", "str_name", "uint32_newflag", "uint64_time", "msg_bind_fri", "str_desc", "uint32_level", "rpt_taskinfos", "uint32_point", "uint32_point_level2", "uint32_point_level3", "uint32_seq_level2", "uint32_seq_level3", "uint64_time_level2", "uint64_time_level3", "str_desc_level2", "str_desc_level3", "uint32_endtime", "str_detail_url", "str_detail_url_2", "str_detail_url_3", "str_task_desc", "str_task_desc_2", "str_task_desc_3", "uint32_level_count", "uint32_no_progress", "str_resource", "uint32_fromuin_level", "uint32_unread", "uint32_unread_2", "uint32_unread_3"}, new Object[]{0, 0, 0L, "", 0, 0L, null, "", 0, null, 0, 0, 0, 0L, 0L, 0L, 0L, "", "", 0, "", "", "", "", "", "", 0, 0, "", 0, 0, 0, 0}, common$MedalInfo.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint32_seq = PBField.initUInt64(0);
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint32_newflag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public common$BindInfo msg_bind_fri = new MessageMicro<common$BindInfo>() { // from class: tencent.im.medal.common$BindInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_fri_uin", "str_fri_nick", "uint64_time", "uint32_bind_status"}, new Object[]{0L, "", 0L, 0}, common$BindInfo.class);
        public final PBUInt64Field uint64_fri_uin = PBField.initUInt64(0);
        public final PBStringField str_fri_nick = PBField.initString("");
        public final PBUInt64Field uint64_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_bind_status = PBField.initUInt32(0);
    };
    public final PBStringField str_desc = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBRepeatMessageField<common$MedalTaskInfo> rpt_taskinfos = PBField.initRepeatMessage(common$MedalTaskInfo.class);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point_level2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point_level3 = PBField.initUInt32(0);
    public final PBUInt64Field uint32_seq_level2 = PBField.initUInt64(0);
    public final PBUInt64Field uint32_seq_level3 = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time_level2 = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time_level3 = PBField.initUInt64(0);
    public final PBStringField str_desc_level2 = PBField.initString("");
    public final PBStringField str_desc_level3 = PBField.initString("");
    public final PBUInt32Field uint32_endtime = PBField.initUInt32(0);
    public final PBStringField str_detail_url = PBField.initString("");
    public final PBStringField str_detail_url_2 = PBField.initString("");
    public final PBStringField str_detail_url_3 = PBField.initString("");
    public final PBStringField str_task_desc = PBField.initString("");
    public final PBStringField str_task_desc_2 = PBField.initString("");
    public final PBStringField str_task_desc_3 = PBField.initString("");
    public final PBUInt32Field uint32_level_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_no_progress = PBField.initUInt32(0);
    public final PBStringField str_resource = PBField.initString("");
    public final PBUInt32Field uint32_fromuin_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_3 = PBField.initUInt32(0);
}
