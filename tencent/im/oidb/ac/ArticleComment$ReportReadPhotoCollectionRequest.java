package tencent.im.oidb.ac;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ArticleComment$ReportReadPhotoCollectionRequest extends MessageMicro<ArticleComment$ReportReadPhotoCollectionRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt64Field cuin = PBField.initUInt64(0);
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field report_timing_type = PBField.initUInt32(0);
    public final PBUInt32Field total_remain_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<ArticleComment$ReadPhotoItemInfo> item = PBField.initRepeatMessage(ArticleComment$ReadPhotoItemInfo.class);
    public final PBRepeatField<ByteStringMicro> recommend_article_id = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        String[] strArr = {"versionInfo", "cuin", AppConstants.Key.SHARE_REQ_ARTICLE_ID, "report_timing_type", "total_remain_time", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "recommend_article_id"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 58}, strArr, new Object[]{"", 0L, byteStringMicro, 0, 0, null, byteStringMicro}, ArticleComment$ReportReadPhotoCollectionRequest.class);
    }
}
