package tencent.im.oidb.cloud_print;

import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class cloud_print$QQFileDownloadReqParams extends MessageMicro<cloud_print$QQFileDownloadReqParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"c2coffline_req_params", "group_file_req_params", "collect_file_req_params"}, new Object[]{null, null, null}, cloud_print$QQFileDownloadReqParams.class);
    public cloud_print$C2COfflineFileReqParams c2coffline_req_params = new cloud_print$C2COfflineFileReqParams();
    public cloud_print$GroupFileReqParams group_file_req_params = new cloud_print$GroupFileReqParams();
    public cloud_print$CollectFileReqParams collect_file_req_params = new MessageMicro<cloud_print$CollectFileReqParams>() { // from class: tencent.im.oidb.cloud_print.cloud_print$CollectFileReqParams
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cid", Utils.KEY_BUSINESS_ID, "str_file_name"}, new Object[]{"", "", ""}, cloud_print$CollectFileReqParams.class);
        public final PBStringField cid = PBField.initString("");
        public final PBStringField fid = PBField.initString("");
        public final PBStringField str_file_name = PBField.initString("");
    };
}
