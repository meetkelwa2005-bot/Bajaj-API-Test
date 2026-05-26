package com.bajaj.apitest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RootController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getLandingPage() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Bajaj SDE API - Meet Kelwa</title>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;800&display=swap\" rel=\"stylesheet\">\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            font-family: 'Outfit', sans-serif;\n" +
                "        }\n" +
                "        body {\n" +
                "            background: radial-gradient(circle at 50% 50%, #1a1b36 0%, #0d0e15 100%);\n" +
                "            color: #ffffff;\n" +
                "            min-height: 100vh;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            padding: 20px;\n" +
                "            overflow-x: hidden;\n" +
                "        }\n" +
                "        .container {\n" +
                "            background: rgba(255, 255, 255, 0.03);\n" +
                "            backdrop-filter: blur(16px);\n" +
                "            -webkit-backdrop-filter: blur(16px);\n" +
                "            border: 1px solid rgba(255, 255, 255, 0.08);\n" +
                "            border-radius: 24px;\n" +
                "            width: 100%;\n" +
                "            max-width: 600px;\n" +
                "            padding: 40px;\n" +
                "            box-shadow: 0 20px 50px rgba(0, 0, 0, 0.3);\n" +
                "            text-align: center;\n" +
                "            position: relative;\n" +
                "            animation: fadeIn 0.8s ease-out;\n" +
                "        }\n" +
                "        @keyframes fadeIn {\n" +
                "            from { opacity: 0; transform: translateY(20px); }\n" +
                "            to { opacity: 1; transform: translateY(0); }\n" +
                "        }\n" +
                "        .status-badge {\n" +
                "            display: inline-flex;\n" +
                "            align-items: center;\n" +
                "            background: rgba(0, 230, 118, 0.1);\n" +
                "            border: 1px solid rgba(0, 230, 118, 0.3);\n" +
                "            color: #00e676;\n" +
                "            padding: 6px 14px;\n" +
                "            border-radius: 50px;\n" +
                "            font-size: 0.85rem;\n" +
                "            font-weight: 600;\n" +
                "            margin-bottom: 20px;\n" +
                "            gap: 6px;\n" +
                "        }\n" +
                "        .status-dot {\n" +
                "            width: 8px;\n" +
                "            height: 8px;\n" +
                "            background: #00e676;\n" +
                "            border-radius: 50%;\n" +
                "            box-shadow: 0 0 10px #00e676;\n" +
                "            animation: pulse 1.5s infinite;\n" +
                "        }\n" +
                "        @keyframes pulse {\n" +
                "            0% { transform: scale(0.9); opacity: 0.6; }\n" +
                "            50% { transform: scale(1.1); opacity: 1; }\n" +
                "            100% { transform: scale(0.9); opacity: 0.6; }\n" +
                "        }\n" +
                "        h1 {\n" +
                "            font-size: 2.2rem;\n" +
                "            font-weight: 800;\n" +
                "            margin-bottom: 8px;\n" +
                "            background: linear-gradient(135deg, #a1c4fd 0%, #c2e9fb 100%);\n" +
                "            -webkit-background-clip: text;\n" +
                "            -webkit-text-fill-color: transparent;\n" +
                "        }\n" +
                "        .subtitle {\n" +
                "            color: #8b9bb4;\n" +
                "            font-size: 0.95rem;\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "        .card {\n" +
                "            background: rgba(255, 255, 255, 0.02);\n" +
                "            border: 1px solid rgba(255, 255, 255, 0.04);\n" +
                "            border-radius: 16px;\n" +
                "            padding: 24px;\n" +
                "            text-align: left;\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "        .info-row {\n" +
                "            display: flex;\n" +
                "            justify-content: space-between;\n" +
                "            padding: 12px 0;\n" +
                "            border-bottom: 1px solid rgba(255, 255, 255, 0.05);\n" +
                "        }\n" +
                "        .info-row:last-child {\n" +
                "            border-bottom: none;\n" +
                "        }\n" +
                "        .info-label {\n" +
                "            color: #8b9bb4;\n" +
                "            font-size: 0.9rem;\n" +
                "        }\n" +
                "        .info-val {\n" +
                "            font-weight: 600;\n" +
                "            color: #ffffff;\n" +
                "            font-size: 0.95rem;\n" +
                "        }\n" +
                "        .links {\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            gap: 12px;\n" +
                "        }\n" +
                "        .btn {\n" +
                "            display: flex;\n" +
                "            justify-content: space-between;\n" +
                "            align-items: center;\n" +
                "            background: rgba(255, 255, 255, 0.04);\n" +
                "            border: 1px solid rgba(255, 255, 255, 0.08);\n" +
                "            padding: 16px 20px;\n" +
                "            border-radius: 12px;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            font-weight: 600;\n" +
                "            transition: all 0.3s ease;\n" +
                "            font-size: 0.9rem;\n" +
                "        }\n" +
                "        .btn:hover {\n" +
                "            background: rgba(255, 255, 255, 0.08);\n" +
                "            border-color: rgba(255, 255, 255, 0.2);\n" +
                "            transform: translateY(-2px);\n" +
                "        }\n" +
                "        .btn-tag {\n" +
                "            font-size: 0.75rem;\n" +
                "            font-weight: 800;\n" +
                "            background: #2575fc;\n" +
                "            padding: 4px 8px;\n" +
                "            border-radius: 6px;\n" +
                "            letter-spacing: 0.5px;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            margin-top: 40px;\n" +
                "            color: #4b556b;\n" +
                "            font-size: 0.75rem;\n" +
                "            letter-spacing: 0.5px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"status-badge\">\n" +
                "            <div class=\"status-dot\"></div>\n" +
                "            API Running Live\n" +
                "        </div>\n" +
                "        <h1>Bajaj SDE API Server</h1>\n" +
                "        <div class=\"subtitle\">Acropolis Campus Hiring (May 2026) - API Round</div>\n" +
                "        \n" +
                "        <div class=\"card\">\n" +
                "            <div class=\"info-row\">\n" +
                "                <span class=\"info-label\">Candidate Name</span>\n" +
                "                <span class=\"info-val\">meet kelwa</span>\n" +
                "            </div>\n" +
                "            <div class=\"info-row\">\n" +
                "                <span class=\"info-label\">College Roll Number</span>\n" +
                "                <span class=\"info-val\">0827CI231081</span>\n" +
                "            </div>\n" +
                "            <div class=\"info-row\">\n" +
                "                <span class=\"info-label\">Email Address</span>\n" +
                "                <span class=\"info-val\">meetkelwa230797@acropolis.in</span>\n" +
                "            </div>\n" +
                "            <div class=\"info-row\">\n" +
                "                <span class=\"info-label\">Generated User ID</span>\n" +
                "                <span class=\"info-val\">meet_kelwa_23071997</span>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"links\">\n" +
                "            <a href=\"/health\" class=\"btn\" target=\"_blank\">\n" +
                "                <span>GET /health</span>\n" +
                "                <span class=\"btn-tag\" style=\"background: #00e676; color: #000;\">STATUS CHECK</span>\n" +
                "            </a>\n" +
                "            <a href=\"/bfhl\" class=\"btn\" target=\"_blank\">\n" +
                "                <span>GET /bfhl</span>\n" +
                "                <span class=\"btn-tag\">OPERATION CODE</span>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"footer\">\n" +
                "            BUILT WITH SPRING BOOT & JAVA 17 • HOSTED ON RENDER DOCKER CONTAINER\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        return ResponseEntity.ok(html);
    }
}
