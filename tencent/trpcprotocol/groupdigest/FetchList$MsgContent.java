package tencent.trpcprotocol.groupdigest;

import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import cooperation.qzone.QZoneShareManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FetchList$MsgContent extends MessageMicro<FetchList$MsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 88, 98, 170, 178, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, MapItemKt.ITEM_AVATAR_MIN_WIDTH, f.CTRL_INDEX, 360}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "text", "face_index", "face_text", "image_url", "image_thumbnail_url", "share_title", "share_summary", "share_brief", GetGuildJoinUrlServlet.BUNDLE_KEY_URL, QZoneShareManager.QZONE_SHARE_ACTION, "share_source", AppConstants.Key.SHARE_RES_IMAGE_URL, "file_name", "file_thumbnail_url", "file_size"}, new Object[]{0, "", 0, "", "", "", "", "", "", "", "", "", "", "", "", 0L}, FetchList$MsgContent.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBUInt32Field face_index = PBField.initUInt32(0);
    public final PBStringField face_text = PBField.initString("");
    public final PBStringField image_url = PBField.initString("");
    public final PBStringField image_thumbnail_url = PBField.initString("");
    public final PBStringField share_title = PBField.initString("");
    public final PBStringField share_summary = PBField.initString("");
    public final PBStringField share_brief = PBField.initString("");
    public final PBStringField share_url = PBField.initString("");
    public final PBStringField share_action = PBField.initString("");
    public final PBStringField share_source = PBField.initString("");
    public final PBStringField share_image_url = PBField.initString("");
    public final PBStringField file_name = PBField.initString("");
    public final PBStringField file_thumbnail_url = PBField.initString("");
    public final PBUInt64Field file_size = PBField.initUInt64(0);
}
