package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$DownloadInfo extends MessageMicro<cmd0x346$DownloadInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_key;
    public final PBBytesField bytes_media_platform_download_key;
    public final PBRepeatField<String> rpt_str_downloadip_list;
    public final PBStringField str_cookie;
    public final PBStringField str_download_dns;
    public final PBStringField str_download_domain;
    public final PBStringField str_download_ip;
    public final PBStringField str_download_url;
    public final PBRepeatField<String> str_downloadipv6_list;
    public final PBStringField str_https_download_domain;
    public final PBUInt32Field uint32_https_port;
    public final PBUInt32Field uint32_port;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 162, 242, 320, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, QVipServiceAccountFolderProcessor.CMD, 882, 962, 1042}, new String[]{"bytes_download_key", "str_download_ip", "str_download_domain", "uint32_port", "str_download_url", "rpt_str_downloadip_list", "str_cookie", "uint32_https_port", "str_https_download_domain", "str_download_dns", "bytes_media_platform_download_key", "str_downloadipv6_list"}, new Object[]{byteStringMicro, "", "", 0, "", "", "", Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), "", "", byteStringMicro, ""}, cmd0x346$DownloadInfo.class);
    }

    public cmd0x346$DownloadInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_download_key = PBField.initBytes(byteStringMicro);
        this.str_download_ip = PBField.initString("");
        this.str_download_domain = PBField.initString("");
        this.uint32_port = PBField.initUInt32(0);
        this.str_download_url = PBField.initString("");
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.rpt_str_downloadip_list = PBField.initRepeat(pBStringField);
        this.str_cookie = PBField.initString("");
        this.uint32_https_port = PBField.initUInt32(WebSocketImpl.DEFAULT_WSS_PORT);
        this.str_https_download_domain = PBField.initString("");
        this.str_download_dns = PBField.initString("");
        this.bytes_media_platform_download_key = PBField.initBytes(byteStringMicro);
        this.str_downloadipv6_list = PBField.initRepeat(pBStringField);
    }
}
