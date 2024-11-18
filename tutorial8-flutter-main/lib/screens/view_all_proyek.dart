import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:manpromanpro_mobile/model/proyek.dart';
import 'package:manpromanpro_mobile/utils/reusable_widget.dart';
import 'package:manpromanpro_mobile/utils/jwt_utils.dart';

class ProyekScreen extends StatefulWidget {
  const ProyekScreen({super.key});

  @override
  State<ProyekScreen> createState() => _ProyekScreenState();
}

class _ProyekScreenState extends State<ProyekScreen> {
  Future<List<Proyek>?> fetchProyek() async {
    try {
      // Get JWT token from secure storage
      final jwtToken = await JwtUtils.getUsernameFromJwt();
      if (jwtToken == null) {
        throw Exception("JWT Token not found");
      }

      // Call the API with the token
      final response = await http.get(
        Uri.parse('http://localhost:8080/api/proyek/viewall'),
        headers: {
          'Authorization': 'Bearer $jwtToken',
          'Content-Type': 'application/json',
        },
      );
      
      // Check if the response is successful
      if (response.statusCode == 200) {
        final responseData = json.decode(response.body);
        List<dynamic> proyekData = responseData['data'];

        // Map the response to a list of Proyek objects
        return proyekData.map((json) => Proyek.fromJson(json)).toList();
      } else {
        throw Exception("Failed to fetch proyek: ${response.statusCode}");
      }
    } catch (e) {
      print('Error fetching proyek: $e');
      return null;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('ManproManpro'),
      ),
      body: FutureBuilder<List<dynamic>>(
        future: Future.wait([fetchProyek(), JwtUtils.getUsernameFromJwt()]),
        builder: (BuildContext context, AsyncSnapshot<List<dynamic>> snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          }
          if (!snapshot.hasData || snapshot.data![0] == null) {
            return Padding(
                padding: const EdgeInsets.all(20),
                child: Center(
                    child: Column(
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                      Text.rich(TextSpan(
                        text: 'Hello, ',
                        style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 24,
                            color: Colors.black),
                        children: <TextSpan>[
                          TextSpan(
                              text: '${snapshot.data![1] ?? 'User'}!',
                              style: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  fontSize: 24,
                                  color: Colors.blue.shade600)),
                        ],
                      )),
                      const SizedBox(height: 20),
                      const Text(
                        "Proyek tidak ditemukan",
                        style: TextStyle(fontSize: 16),
                      )
                    ])));
          } else {
            String username = snapshot.data![1] ?? 'User';
            List<Proyek> proyekList = snapshot.data![0];

            return Padding(
                padding: const EdgeInsets.all(20),
                child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Text.rich(TextSpan(
                        text: 'Hello, ',
                        style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 24,
                            color: Colors.black),
                        children: <TextSpan>[
                          TextSpan(
                              text: '$username!',
                              style: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  fontSize: 24,
                                  color: Colors.blue.shade600)),
                        ],
                      )),
                      const SizedBox(height: 20),
                      Expanded(
                        child: ListView.builder(
                          itemCount: proyekList.length,
                          itemBuilder: (_, index) {
                            Proyek proyek = proyekList[index];
                            return Container(
                              margin: const EdgeInsets.symmetric(
                                  horizontal: 16, vertical: 12),
                              padding: const EdgeInsets.all(20.0),
                              decoration: BoxDecoration(
                                color: Colors.white,
                                borderRadius: BorderRadius.circular(15.0),
                                boxShadow: const [
                                  BoxShadow(
                                      color: Colors.black26,
                                      blurRadius: 5.0,
                                      offset: Offset(0, 3)),
                                ],
                              ),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    proyek.nama,
                                    style: const TextStyle(
                                        fontSize: 18,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  const SizedBox(height: 8),
                                  Text(proyek.deskripsi),
                                  const SizedBox(height: 8),
                                  Text(
                                    'Status: ${proyek.status}',
                                    style: TextStyle(
                                        color: proyek.status == 'STARTED'
                                            ? Colors.green
                                            : Colors.red),
                                  ),
                                ],
                              ),
                            );
                          },
                        ),
                      ),
                    ]));
          }
        },
      ),
    );
  }
}
