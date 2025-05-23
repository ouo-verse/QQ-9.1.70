package tvideo;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$QqPromotions extends MessageMicro<TVideoFloatPr$QqPromotions> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"promotionInfo", "displayInfo", CacheTable.TABLE_NAME}, new Object[]{null, null, null}, TVideoFloatPr$QqPromotions.class);
    public TVideoFloatPr$PromotionInfo promotionInfo = new MessageMicro<TVideoFloatPr$PromotionInfo>() { // from class: tvideo.TVideoFloatPr$PromotionInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56}, new String[]{"planID", a.f36094d, "itemID", "itemType", "isCallFrom", "prID", "priority"}, new Object[]{"", "", "", "", Boolean.FALSE, "", 0}, TVideoFloatPr$PromotionInfo.class);
        public final PBStringField planID = PBField.initString("");
        public final PBStringField taskID = PBField.initString("");
        public final PBStringField itemID = PBField.initString("");
        public final PBStringField itemType = PBField.initString("");
        public final PBBoolField isCallFrom = PBField.initBool(false);
        public final PBStringField prID = PBField.initString("");
        public final PBInt32Field priority = PBField.initInt32(0);
    };
    public TVideoFloatPr$QqDisplayInfo displayInfo = new TVideoFloatPr$QqDisplayInfo();
    public TVideoFloatPr$FlowPoolReportInfo reportInfo = new TVideoFloatPr$FlowPoolReportInfo();
}
