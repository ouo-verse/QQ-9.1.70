package tencent.im.troop.flock;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.weiyun.poi.PoiDbManager;

/* loaded from: classes29.dex */
public final class QeventPB$PoiInfo extends MessageMicro<QeventPB$PoiInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 58, 64, 72, 82, 90, 98, 106, 112, 120, 130, 138, 146, 154, 162}, new String[]{PoiDbManager.COL_POI_POI_ID, "name", "poi_type", "type_name", "address", "district_code", "gps", Element.ELEMENT_NAME_DISTANCE, "hot_value", "phone", "country", "province", "city", "poi_num", "poi_order_type", ThreadPoolParams.DEFAULT_THREAD_NAME, "district", "dian_ping_id", "distance_text", "display_name"}, new Object[]{"", "", 0, "", "", 0, null, 0, 0, "", "", "", "", 0, 0, "", "", "", "", ""}, QeventPB$PoiInfo.class);
    public final PBStringField poi_id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field poi_type = PBField.initInt32(0);
    public final PBStringField type_name = PBField.initString("");
    public final PBStringField address = PBField.initString("");
    public final PBInt32Field district_code = PBField.initInt32(0);
    public QeventPB$GPS gps = new QeventPB$GPS();
    public final PBInt32Field distance = PBField.initInt32(0);
    public final PBInt32Field hot_value = PBField.initInt32(0);
    public final PBStringField phone = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBInt32Field poi_num = PBField.initInt32(0);
    public final PBInt32Field poi_order_type = PBField.initInt32(0);
    public final PBStringField default_name = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBStringField dian_ping_id = PBField.initString("");
    public final PBStringField distance_text = PBField.initString("");
    public final PBStringField display_name = PBField.initString("");
}
