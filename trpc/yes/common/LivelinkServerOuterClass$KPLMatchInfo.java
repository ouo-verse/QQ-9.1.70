package trpc.yes.common;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes30.dex */
public final class LivelinkServerOuterClass$KPLMatchInfo extends MessageMicro<LivelinkServerOuterClass$KPLMatchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 96, 106, 112}, new String[]{"schedule_id", "season", VipFunCallConstants.KEY_GROUP, TtmlNode.TAG_REGION, "stage", "host", QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE, "match_timestamp", "match_state", "live_state", "live_link", "zhuwei_state", "stage_text", AudienceReportConst.ROOM_ID}, new Object[]{"", "", "", "", "", null, null, 0L, 0, 0, "", 0, "", 0}, LivelinkServerOuterClass$KPLMatchInfo.class);
    public final PBStringField schedule_id = PBField.initString("");
    public final PBStringField season = PBField.initString("");
    public final PBStringField group = PBField.initString("");
    public final PBStringField region = PBField.initString("");
    public final PBStringField stage = PBField.initString("");
    public LivelinkServerOuterClass$KPLTeam host = new MessageMicro<LivelinkServerOuterClass$KPLTeam>() { // from class: trpc.yes.common.LivelinkServerOuterClass$KPLTeam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"id", VipFunCallConstants.KEY_GROUP, "name", "logo", LocalPhotoFaceInfo.SCORE, "is_tbd"}, new Object[]{"", "", "", "", 0, Boolean.FALSE}, LivelinkServerOuterClass$KPLTeam.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f437243id = PBField.initString("");
        public final PBStringField group = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBStringField logo = PBField.initString("");
        public final PBInt32Field score = PBField.initInt32(0);
        public final PBBoolField is_tbd = PBField.initBool(false);
    };
    public LivelinkServerOuterClass$KPLTeam guest = new MessageMicro<LivelinkServerOuterClass$KPLTeam>() { // from class: trpc.yes.common.LivelinkServerOuterClass$KPLTeam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"id", VipFunCallConstants.KEY_GROUP, "name", "logo", LocalPhotoFaceInfo.SCORE, "is_tbd"}, new Object[]{"", "", "", "", 0, Boolean.FALSE}, LivelinkServerOuterClass$KPLTeam.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f437243id = PBField.initString("");
        public final PBStringField group = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBStringField logo = PBField.initString("");
        public final PBInt32Field score = PBField.initInt32(0);
        public final PBBoolField is_tbd = PBField.initBool(false);
    };
    public final PBInt64Field match_timestamp = PBField.initInt64(0);
    public final PBInt32Field match_state = PBField.initInt32(0);
    public final PBInt32Field live_state = PBField.initInt32(0);
    public final PBStringField live_link = PBField.initString("");
    public final PBInt32Field zhuwei_state = PBField.initInt32(0);
    public final PBStringField stage_text = PBField.initString("");
    public final PBInt32Field room_id = PBField.initInt32(0);
}
