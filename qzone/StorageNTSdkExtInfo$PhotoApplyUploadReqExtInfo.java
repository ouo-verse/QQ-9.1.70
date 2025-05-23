package qzone;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.weiyun.poi.PoiDbManager;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo extends MessageMicro<StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 64, 72, 80, 88, 98, 104, 114, 122, 130}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, JobDbManager.COL_UP_BATCH_ID, "space_id", "vid", PoiDbManager.TBL_POI, "photo_desc", "batch_upload_time", "batch_upload_num", "batch_cur_num", "album_type_id", "need_watermark", MosaicConstants$JsProperty.PROP_ENV, "distinct_use", "exif_info", "common_ext_info", "external_ext_info"}, new Object[]{"", 0L, "", "", null, "", 0L, 0, 0, 0, Boolean.FALSE, null, 0, null, null, null}, StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.class);
    public final PBStringField album_id = PBField.initString("");
    public final PBInt64Field batch_id = PBField.initInt64(0);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
    public StorageNTSdkExtInfo$Poi poi = new MessageMicro<StorageNTSdkExtInfo$Poi>() { // from class: qzone.StorageNTSdkExtInfo$Poi
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"poi_x", "poi_y", "poi_name"}, new Object[]{"", "", ""}, StorageNTSdkExtInfo$Poi.class);
        public final PBStringField poi_x = PBField.initString("");
        public final PBStringField poi_y = PBField.initString("");
        public final PBStringField poi_name = PBField.initString("");
    };
    public final PBStringField photo_desc = PBField.initString("");
    public final PBInt64Field batch_upload_time = PBField.initInt64(0);
    public final PBUInt32Field batch_upload_num = PBField.initUInt32(0);
    public final PBUInt32Field batch_cur_num = PBField.initUInt32(0);
    public final PBUInt32Field album_type_id = PBField.initUInt32(0);
    public final PBBoolField need_watermark = PBField.initBool(false);
    public StoragePhotoSdkCommon$EnvInfo env = new StoragePhotoSdkCommon$EnvInfo();
    public final PBUInt32Field distinct_use = PBField.initUInt32(0);
    public StorageNTSdkExtInfo$ExifInfo exif_info = new StorageNTSdkExtInfo$ExifInfo();
    public StorageNTSdkExtInfo$CommonExtensionInfo common_ext_info = new StorageNTSdkExtInfo$CommonExtensionInfo();
    public StorageNTSdkExtInfo$ExternalExtensionInfo external_ext_info = new MessageMicro<StorageNTSdkExtInfo$ExternalExtensionInfo>() { // from class: qzone.StorageNTSdkExtInfo$ExternalExtensionInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], StorageNTSdkExtInfo$ExternalExtensionInfo.class);
    };
}
